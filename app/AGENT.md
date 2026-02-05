=========================================
APP DE RUTINAS & NUTRICIÓN – RESUMEN
=========================================

1. ESTRUCTURA GENERAL
--------------------
app/
├─ build.gradle
├─ src/main/
│   ├─ AndroidManifest.xml
│   ├─ java/com/tuempresa/tugymapp/
│   │   ├─ App.kt                   # Application class, inicialización global
│   │   ├─ di/                      # Inyección de dependencias (Hilt/Koin)
│   │   │    ├─ NetworkModule.kt
│   │   │    ├─ RepositoryModule.kt
│   │   │    └─ UseCaseModule.kt
│   │   ├─ core/                    # Utilidades comunes y helpers
│   │   │    ├─ constants/
│   │   │    ├─ utils/
│   │   │    └─ extensions/
│   │   ├─ data/                    # Capa de datos
│   │   │    ├─ local/              # Room DB
│   │   │    │   ├─ AppDatabase.kt
│   │   │    │   ├─ dao/
│   │   │    │   │   ├─ RoutineDao.kt
│   │   │    │   │   ├─ ExerciseDao.kt
│   │   │    │   │   └─ RecipeDao.kt
│   │   │    ├─ remote/             # Retrofit / API
│   │   │    │   ├─ ApiService.kt
│   │   │    │   ├─ dto/            # Data Transfer Objects
│   │   │    │   │   ├─ RoutineDto.kt
│   │   │    │   │   └─ RecipeDto.kt
│   │   │    ├─ repository/         # Implementaciones concretas de repositorios
│   │   │    │   ├─ RoutineRepositoryImpl.kt
│   │   │    │   └─ RecipeRepositoryImpl.kt
│   │   ├─ domain/                  # Capa de dominio
│   │   │    ├─ model/              # Modelos internos de negocio
│   │   │    │   ├─ Routine.kt
│   │   │    │   ├─ Exercise.kt
│   │   │    │   └─ Recipe.kt
│   │   │    ├─ repository/         # Interfaces de repositorios
│   │   │    │   ├─ RoutineRepository.kt
│   │   │    │   └─ RecipeRepository.kt
│   │   │    ├─ usecase/            # Casos de uso
│   │   │    │   ├─ GetUserRoutinesUseCase.kt
│   │   │    │   ├─ ImportRoutineUseCase.kt
│   │   │    │   └─ GenerateQrUseCase.kt
│   │   ├─ presentation/            # UI y ViewModels
│   │   │    ├─ navigation/         # NavGraph
│   │   │    ├─ components/         # Composables reutilizables
│   │   │    ├─ screens/            # Pantallas y ViewModels
│   │   │    │   ├─ home/
│   │   │    │   ├─ routines/
│   │   │    │   ├─ recipes/
│   │   │    │   └─ profile/
│   │   │    ├─ theme/              # Colores, tipografía, shapes
│   │   │    └─ MainActivity.kt     # Activity principal
│   │   └─ worker/                  # Tareas en background (WorkManager)
│   │        ├─ SyncWorker.kt
│   │        └─ NotificationWorker.kt
│   └─ res/                         # Recursos
│        ├─ drawable/
│        ├─ layout/
│        ├─ values/
│        └─ raw/

2. CAPAS Y RESPONSABILIDADES
---------------------------
- domain:
    - Modelos de negocio (limpios, sin dependencias externas)
    - Interfaces de repositorios (contracts)
    - UseCases: acciones concretas de negocio
- data:
    - Implementaciones concretas de repositorios (RepositoryImpl)
    - Acceso a API (Retrofit) y DB local (Room)
    - DTOs: estructuras exactas de la API
- presentation:
    - UI con Compose
    - ViewModels
    - Navegación
- core:
    - Constantes globales
    - Helpers / Utils
    - Extension functions
    - Wrappers de UI/Estado
- di:
    - Configuración de inyección de dependencias (Hilt/Koin)
- worker:
    - Tareas en background (sincronización, notificaciones)

3. FLUJO DE DATOS
-----------------
Usuario abre app:
MainActivity → NavGraph → Screen → ViewModel → UseCase → Repository → DataSource (API/DB)

DTO: datos como vienen de la API
Domain Model: datos limpios internos
Mapper: transforma DTO ↔ Domain Model
RepositoryImpl: implementa Repository, llama a API/DB y hace mapping

4. CONCEPTOS CLAVE
-----------------
- Repository (domain): interface
- RepositoryImpl (data): implementación concreta
- UseCase (domain): lógica de negocio específica
- DTO (data/remote/dto): estructura de datos de la API
- App.kt: inicialización global
- MainActivity.kt: entry point UI
- Worker: tareas background, sincronización y notificaciones
- DI: Dependency Injection, Hilt/Koin para inyectar dependencias automáticamente
- Core: utilidades, extensiones, constantes, wrappers

5. EJEMPLOS
------------
# DTO → Domain
RoutineDto(id, title, exercises_count) → Routine(id, name, exerciseCount)

# UseCase
class GetUserRoutinesUseCase(private val repo: RoutineRepository) {
suspend operator fun invoke(userId: String) = repo.getUserRoutines(userId)
}

# Worker
class SyncWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
override suspend fun doWork(): Result {
syncRoutines()
syncRecipes()
return Result.success()
}
}

=========================================

=========================================
FLUJO DE DATOS & ARQUITECTURA – ASCII
=========================================

           ┌─────────────────────────────┐
           │        App.kt               │
           │(Inicializa DI, Hilt/Koin)  │
           └──────────────┬─────────────┘
                          │
                          ▼
           ┌─────────────────────────────┐
           │     MainActivity.kt        │
           │(NavHost Compose / UI entry)│
           └──────────────┬─────────────┘
                          │
                          ▼
           ┌─────────────────────────────┐
           │       Screens / Compose     │
           │ (RoutinesScreen, RecipesScreen, HomeScreen, etc.) │
           └──────────────┬─────────────┘
                          │
                          ▼
           ┌─────────────────────────────┐
           │        ViewModel            │
           │(State management, UI logic)│
           └──────────────┬─────────────┘
                          │
                          ▼
           ┌─────────────────────────────┐
           │          UseCase            │
           │(GetUserRoutinesUseCase,    │
           │ ImportRoutineUseCase, etc.)│
           └──────────────┬─────────────┘
                          │
                          ▼
           ┌─────────────────────────────┐
           │        Repository           │
           │ (domain/interface)         │
           └──────────────┬─────────────┘
                          │
                          ▼
           ┌─────────────────────────────┐
           │     RepositoryImpl          │
           │(data layer, implementa     │
           │ API + DB, mapea DTO→Domain)│
           └──────────────┬─────────────┘
                          │
          ┌───────────────┴───────────────┐
          │                               │
          ▼                               ▼
┌─────────────────┐             ┌─────────────────┐
│   Remote API    │             │   Local DB      │
│ (Retrofit + DTO)│             │ (Room / Entities)│
└─────────────────┘             └─────────────────┘
│
▼
┌─────────────────────────────┐
│           DTO               │
│(Data Transfer Objects,     │
│ estructuras exactas de la API) │
└──────────────┬─────────────┘
│
▼
┌─────────────────────────────┐
│      Domain Models          │
│ (Routine, Exercise, Recipe)│
└──────────────┬─────────────┘
│
▼
┌─────────────────────────────┐
│            Core             │
│ (Utils, Extensions,        │
│ Constants, Wrappers UI)    │
└──────────────┬─────────────┘
│
▼
┌─────────────────────────────┐
│          Worker             │
│(SyncWorker, NotificationWorker)│
│Background tasks:             │
│- sincronizar rutinas/recetas │
│- enviar notificaciones       │
└─────────────────────────────┘

Notas:
------
- DI (Hilt/Koin) conecta ViewModel → UseCase → RepositoryImpl automáticamente.
- DTO y Domain Model tienen mappers (toDomain(), toDto()).
- Worker puede llamar a UseCases directamente para sincronizar datos.
- Core contiene helpers que pueden ser usados en cualquier capa.
- MainActivity sólo maneja la UI inicial y NavGraph, no lógica de negocio.
- Screens/Compose sólo manejan presentación y llaman a ViewModel.
- UseCase encapsula la lógica de negocio específica.
- Repository interface define contrato; RepositoryImpl implementa acceso a datos.

=========================================
UTILIDADES DE LA APP – RESUMEN
=========================================

PARA USUARIOS (APP MÓVIL – KOTLIN)
---------------------------------
- Crear y gestionar rutinas propias de ejercicio.
- Acceder a recetas propuestas por el administrador.
- Publicar recetas de forma pública (en plan gratuito o premium).
- Importar rutinas de forma rápida mediante código QR.
- Generar códigos QR para compartir rutinas (en plan premium).
- Ver descripción de ejercicios con imagen/video por defecto.
- Ver contenido personalizado del gimnasio en caso de estar inscripto.
- Filtrar ejercicios por grupo muscular o función (bulk/cut).
- Acceder a tips de ejercicios y nutrición generales.
- **Recibir notificaciones para recordar ir al gimnasio** (push notifications con horarios personalizados).

PARA GIMNASIOS (APP DESKTOP QT / PANEL WEB)
------------------------------------------
- Crear rutinas privadas y/o públicas.
- Configurar rutinas diarias (daily routines).
- Subir videos/explicaciones de ejercicios personalizadas.
- Permitir a usuarios anotarse en clases/cursos/seminarios con o sin cupos.
- Publicar anuncios internos.
- Publicar tips nutricionales/físicos personalizados.
- Publicar recetas generales/daily meal.
- Mostrar información del gimnasio: horarios, clases, redes, profesores.
- Generar códigos QR para profesores y el propio gimnasio.
- Gestionar acceso de usuarios por email, cédula u otros métodos.
- Plan básico: gestión manual de usuarios habilitados.
- Plan premium: control automático de pago/permanencia e integración de pago en app y/o control de asistencia.

PARA PROFESORES (APP MÓVIL KOTLIN)
---------------------------------
- Acceder a rutinas de los alumnos.
- Generar y compartir rutinas por QR.
- Ver inscriptos en clases/seminarios.
- Publicar tips o contenido personalizado.

FUTURAS FUNCIONALIDADES (NO PRIORITARIAS)
-----------------------------------------
- Visualización de rutinas y datos en televisores, tablets o relojes inteligentes.
- Integración con sistemas externos de control de acceso/turnos.
- Recordatorios más avanzados con IA según hábitos del usuario.

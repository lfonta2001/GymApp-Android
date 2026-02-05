# 📌 Roadmap / Progress Checker – App Gimnasio & Rutinas

## FASE 0 – DEFINICIÓN Y PREPARACIÓN (Semana 1)
- [ ] Definir claramente funcionalidades mínimas para usuarios y gimnasios.
- [ ] Definir modelo de negocio (planes gratuitos/premium).
- [ ] Crear documento de arquitectura (este .txt con todo el contexto).
- [ ] Seleccionar stack definitivo:
    - App usuarios: Kotlin + Compose
    - App gimnasios: Qt Desktop
    - Servidor: Node.js/TypeScript
- [ ] Crear repositorio Git con estructura inicial.

---

## FASE 1 – BACKEND BÁSICO (Semanas 2–3)
- [ ] Configurar proyecto Node.js con TypeScript.
- [ ] Definir modelos base (User, Gym, Routine, Recipe).
- [ ] Implementar endpoints REST iniciales:
    - [ ] CRUD de usuarios
    - [ ] CRUD de gimnasios
    - [ ] CRUD de rutinas
- [ ] Configurar base de datos (PostgreSQL/MySQL/MongoDB).
- [ ] Implementar autenticación básica (JWT, email/contraseña).
- [ ] Probar endpoints con Postman.

---

## FASE 2 – APP USUARIOS (Semanas 4–6)
- [ ] Crear proyecto Android en Kotlin + Compose.
- [ ] Implementar estructura de carpetas (data/domain/presentation/core).
- [ ] Configurar DI (Hilt/Koin).
- [ ] Implementar navegación básica (NavHost + pantallas vacías).
- [ ] Crear modelos domain (Routine, Exercise, Recipe).
- [ ] Implementar Repository/UseCases iniciales para rutinas.
- [ ] Consumir API del backend para rutinas y recetas.
- [ ] Implementar UI básica para:
    - [ ] Ver rutinas propias
    - [ ] Ver recetas
- [ ] Implementar notificaciones push (recordar ir al gimnasio).

---

## FASE 3 – APP GIMNASIOS (Semanas 7–8)
- [ ] Crear proyecto Qt Desktop.
- [ ] Diseñar UI básica para gestionar rutinas y usuarios.
- [ ] Conectar con API del backend.
- [ ] Permitir subir videos/explicaciones y recetas.
- [ ] Implementar control manual de acceso de usuarios (plan básico).

---

## FASE 4 – FUNCIONALIDADES PREMIUM (Semanas 9–11)
- [ ] Implementar generación y lectura de códigos QR en ambas apps.
- [ ] Implementar publicación de recetas por usuarios (planes).
- [ ] Integrar pagos en app (Stripe/PayPal).
- [ ] Integrar control automático de pagos/permanencia para gimnasios (plan premium).

---

## FASE 5 – MEJORAS Y PERSONALIZACIÓN (Semanas 12–14)
- [ ] Añadir filtros avanzados (grupo muscular, bulk/cut).
- [ ] Añadir tips personalizados de ejercicios/nutrición.
- [ ] Añadir anuncios, clases/cursos/seminarios con cupos.
- [ ] Añadir información del gimnasio (horarios, redes, profesores).

---

## FASE 6 – TESTING Y LANZAMIENTO (Semanas 15–16)
- [ ] Test unitarios en backend y apps.
- [ ] Test de integración (API + apps).
- [ ] Ajustes finales de UI/UX.
- [ ] Beta cerrada con algunos usuarios y gimnasios.
- [ ] Recibir feedback y corregir errores.

---

## FASE 7 – FUTURO (Post-Lanzamiento)
- [ ] Integrar app con tablets/televisores/relojes inteligentes.
- [ ] Añadir analítica de uso (tracking rutinas, progresos).
- [ ] Explorar IA para recomendaciones personalizadas.
- [ ] Mejorar notificaciones inteligentes.
- [ ] Añadir más métodos de autenticación (cédula, biometría).

# Copilot Instructions for StudioTasks

## Project Overview
StudioTasks is an Angular application generated with Angular CLI v20.1.1. The main entry point is `src/main.ts`, and the root module/component structure is under `src/app/`. Routing is handled via Angular's router, with the primary outlet defined in `src/app/app.html`.

## Key Files & Structure
- `src/app/`: Contains main app logic, configuration, routes, and styles.
  - `app.ts`: Main app component logic.
  - `app.config.ts`: App configuration.
  - `app.routes.ts`: Angular route definitions.
  - `app.html`: Root template (contains `<router-outlet>` for navigation).
- `public/`: Static assets (e.g., favicon).
- `index.html`: Main HTML entry point.
- `styles.css`: Global styles.

## Developer Workflows
- **Start Dev Server:** `ng serve` (reloads on source changes)
- **Build:** `ng build` (outputs to `dist/`)
- **Unit Tests:** `ng test` (Karma runner)
- **E2E Tests:** `ng e2e` (framework not included by default)
- **Generate Components:** `ng generate component <name>`

## Patterns & Conventions
- **Routing:** All navigation is managed via Angular Router. Route definitions are in `app.routes.ts`.
- **Component Structure:** Use Angular CLI for scaffolding. Place new components in `src/app/`.
- **Styles:** Component-specific styles in `.css` files next to component logic. Global styles in `styles.css`.
- **Testing:** Unit tests are colocated with components (e.g., `app.spec.ts`).
- **No custom build/test scripts:** All workflows use standard Angular CLI commands.

## Integration Points
- No custom backend or API integration is present by default.
- Static assets are served from `public/`.
- External dependencies are managed via `package.json` (Angular, Karma, etc.).

## Examples
- To add a new route, update `app.routes.ts` and reference the new component in `src/app/`.
- To scaffold a new feature, use `ng generate component feature-name` and follow the file placement conventions.

## References
- See `README.md` for more details on commands and workflow.
- For Angular CLI usage, refer to [Angular CLI Overview](https://angular.dev/tools/cli).

---
_If any conventions or workflows are unclear, please provide feedback so this guide can be improved._

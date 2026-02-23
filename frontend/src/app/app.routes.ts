import { Routes } from '@angular/router';
import { TaskListComponent } from './task-list/task-list';
import { TaskForm } from './task-form/task-form';

export const routes: Routes = [

    { path: 'tarefas', component: TaskListComponent },
    { path: 'nova', component: TaskForm},
    { path: '', redirectTo: 'tarefas', pathMatch: 'full' }

];
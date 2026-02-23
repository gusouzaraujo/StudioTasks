import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { Task } from '../task';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-list.html',
  styleUrls: ['./task-list.css']
})
export class TaskListComponent implements OnInit {

  tasks: Task[] = [];
  confirmingDeleteId: number | null = null; // 🔹 NOVO

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.loadTasks();
  }

  private loadTasks(): void {
    this.taskService.getTasks().subscribe({
      next: (response) => {
        this.tasks = response;
      },
      error: (err) => {
        console.error('Erro ao carregar tarefas', err);
      }
    });
  }

  toggleTaskStatus(task: Task): void {
    const updated = { ...task, completed: !task.completed };

    this.taskService.updateTask(task.id!, updated).subscribe({
      next: () => {
        this.loadTasks();
      },
      error: (err) => {
        console.error('Erro ao atualizar o status da tarefa', err);
      }
    });
  }

  startEdit(task: Task): void {
    task.editing = true;
    task.editingTitle = task.title;
  }

  cancelEdit(task: Task): void {
    task.editing = false;
    task.editingTitle = '';
  }

  saveEdit(task: Task): void {
    if (!task.editingTitle?.trim()) {
      return;
    }

    const updated: Task = {
      ...task,
      title: task.editingTitle
    };

    this.taskService.updateTask(task.id!, updated).subscribe({
      next: () => {
        task.editing = false;
        task.editingTitle = '';
        this.loadTasks();
      },
      error: (err) => {
        console.error('Erro ao editar tarefa', err);
      }
    });
  }

  // 🔹 ABRE A MODAL
  askDelete(task: Task): void {
    this.confirmingDeleteId = task.id!;
  }

  // 🔹 CANCELA
  cancelDelete(): void {
    this.confirmingDeleteId = null;
  }

  // 🔹 CONFIRMA E DELETA
  confirmDelete(): void {
    if (this.confirmingDeleteId === null) return;

    this.taskService.deleteTask(this.confirmingDeleteId).subscribe({
      next: () => {
        this.confirmingDeleteId = null;
        this.loadTasks();
      },
      error: (err) => {
        console.error('Erro ao deletar', err);
        this.confirmingDeleteId = null;
      }
    });
  }
}
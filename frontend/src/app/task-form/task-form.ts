import { FormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { NgClass, NgIf } from '@angular/common';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [FormsModule, NgClass, NgIf],
  templateUrl: './task-form.html',
  styleUrls: ['./task-form.css']
})

export class TaskForm {
  taskTitle: string = '';
  mensagem: string ='';
  mensagemTipo: 'erro' | 'sucesso' | ''='';

constructor (private taskService: TaskService){}

salvarTarefa(): void {
  if (!this.taskTitle.trim()) {
    this.mensagem = '⚠ TÍTULO OBRIGATÓRIO';
    this.mensagemTipo = 'erro';
    return;
  }

  const novaTarefa = {
    title: this.taskTitle,
    completed: false
  };

  this.taskService.addTask(novaTarefa).subscribe({
    next: () => {
      this.mensagem = `📝 NOVA TAREFA CRIADA: ${this.taskTitle}`;
      this.mensagemTipo = 'sucesso';
      this.taskTitle = '';
    },
    error: (err) => {
      console.error('Erro ao criar tarefa', err);
      this.mensagem = '❌ ERRO AO CRIAR TAREFA';
      this.mensagemTipo = 'erro';
    }
  });
}
}
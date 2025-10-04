# Práctica: RecyclerView con Edición y Long Click


---

## bjetivos de Aprendizaje

### 1. Detectar Long Click en elementos
```kotlin
itemView.setOnLongClickListener {
    val pos = bindingAdapterPosition
    if (pos != RecyclerView.NO_POSITION) {
        mostrarMenuOpciones(pos, usuario)
    }
    true
}

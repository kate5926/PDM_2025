import 'package:flutter/material.dart';
import '../models/user.dart';

class UserFormScreen extends StatefulWidget {
  final User? usuario;
  final int? indice;

  const UserFormScreen({super.key, this.usuario, this.indice});

  @override
  State<UserFormScreen> createState() => _UserFormScreenState();
}

class _UserFormScreenState extends State<UserFormScreen> {
  final _formKey = GlobalKey<FormState>();
  late String _nombre;
  String _genero = 'Masculino';
  bool _activo = true;
  late int _edad;
  late String _correo;

  @override
  void initState() {
    super.initState();
    // Inicializa los valores del formulario con los datos del usuario existente (si se está editando)
    // o con valores por defecto (si se está creando uno nuevo)
    if (widget.usuario != null) {
      _nombre = widget.usuario!.nombre;
      _genero = widget.usuario!.genero;
      _activo = widget.usuario!.activo;
      _edad = widget.usuario!.edad;
      _correo = widget.usuario!.correo;
    } else {
      _nombre = '';
      _edad = 0;
      _correo = '';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.usuario == null ? 'Agregar Usuario' : 'Editar Usuario'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              // Campo para el nombre del usuario
              TextFormField(
                initialValue: _nombre,
                decoration: const InputDecoration(labelText: 'Nombre'),
                validator: (value) =>
                value == null || value.isEmpty ? 'Ingrese un nombre válido' : null,
                onSaved: (value) => _nombre = value!,
              ),
              const SizedBox(height: 20),
              
              // Campo para la edad del usuario
              TextFormField(
                initialValue: _edad.toString(),
                decoration: const InputDecoration(labelText: 'Edad'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) return 'Ingrese una edad';
                  final num = int.tryParse(value);
                  if (num == null || num <= 0) return 'Edad debe ser un número mayor a 0';
                  return null;
                },
                onSaved: (value) => _edad = int.parse(value!),
              ),
              const SizedBox(height: 20),
              
              // Campo para el correo electrónico del usuario
              TextFormField(
                initialValue: _correo,
                decoration: const InputDecoration(labelText: 'Correo Electrónico'),
                validator: (value) {
                  if (value == null || value.isEmpty) return 'Ingrese un correo';
                  final emailRegex = RegExp(r'^[^@]+@[^@]+\.[^@]+');
                  if (!emailRegex.hasMatch(value)) return 'Formato de correo inválido';
                  return null;
                },
                onSaved: (value) => _correo = value!,
              ),
              const SizedBox(height: 20),
              
              // Selector de género con botones de radio
              const Text('Género'),
              Row(
                children: [
                  Expanded(
                    child: RadioListTile(
                      title: const Text('Masculino'),
                      value: 'Masculino',
                      groupValue: _genero,
                      onChanged: (value) => setState(() => _genero = value!),
                    ),
                  ),
                  Expanded(
                    child: RadioListTile(
                      title: const Text('Femenino'),
                      value: 'Femenino',
                      groupValue: _genero,
                      onChanged: (value) => setState(() => _genero = value!),
                    ),
                  ),
                ],
              ),
              
              // Switch para indicar si el usuario está activo
              SwitchListTile(
                title: const Text('Activo'),
                value: _activo,
                onChanged: (value) => setState(() => _activo = value),
              ),
              const SizedBox(height: 30),
              
              // Botón para guardar o actualizar el usuario
              ElevatedButton(
                onPressed: () {
                  // Valida el formulario antes de guardar
                  if (_formKey.currentState!.validate()) {
                    _formKey.currentState!.save();
                    // Crea un nuevo objeto User con los datos del formulario
                    final user = User(
                      nombre: _nombre,
                      genero: _genero,
                      activo: _activo,
                      edad: _edad,
                      correo: _correo,
                    );
                    // Retorna el usuario a la pantalla anterior
                    Navigator.pop(context, user);
                  }
                },
                child: Text(widget.usuario == null ? 'Guardar' : 'Actualizar'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

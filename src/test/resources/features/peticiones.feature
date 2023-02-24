@ServiciosApi
Feature: Automatización E2E en los endpoints

  @GetStatusSquema
  Scenario: Validar estado y esquema del endpoints GET
    When Se llama la API Get members
    Then Debería ver el código de estado 200
    Then Valido el esquema de la respuesta "GetJsonSchema"

  @GetId
  Scenario Outline: Obtener un member con éxito
    When Se llama la API GetId members "<id>"
    Then Valido que la busqueda sea correcta "<nombre>"

    Examples: Tabla ids
      | id | nombre |
      | 1  | Monil  |

  @Post
  Scenario Outline: Registro de member por el método POST
    When Se llama la API Post members
      | nombre   | genero   |
      | <nombre> | <genero> |
    Then Válido el registro exitoso 201

    Examples: Tabla Empleados
      | nombre | genero |
      | Daniel | Male   |

  @Update
  Scenario Outline: Actualización member por el método Delete
    When Se llama la API Update members
      | nombre   | genero   | id   |
      | <nombre> | <genero> | <id> |
    Then Debería actualizar el member correctamente 200
    Then Valido el esquema de la respuesta "UpdateJsonSchema"

    Examples: Tabla members a actualizar
      | nombre | genero | id |
      | Automations | Male   | 4  |

  @Delete
  Scenario Outline: Eliminar member por el método Delete
    When Se llama la API Delete members "<id>"
    Then Debería ver el código 200
    Then Valido el esquema de la respuesta "DeleteJsonSchema"

    Examples: Tabla Id
      | id |
      | 3  |
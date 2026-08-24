# CadastroLivros — Atividade 02 (Navegação entre telas)

App de cadastro de livros com **duas telas**, em Kotlin + XML (Views).

| Tela | Activity | O que faz |
|------|----------|-----------|
| 1 | `MainActivity` | Campos de título e autor + botão **Cadastrar** |
| 2 | `DetalhesActivity` | Exibe os detalhes do livro cadastrado |

## Como abrir

1. Descompacte o arquivo. Se o Windows criar uma pasta `CadastroLivros` **dentro**
   de outra `CadastroLivros`, use a de dentro — é a que contém o `settings.gradle.kts`.
2. Android Studio → **File → Open…** → selecione a pasta que tem o `settings.gradle.kts`.
3. Clique em **Trust Project** se o diálogo aparecer.
4. Aguarde o *Gradle Sync* e rode no ▶ (configuração `app`).

## Como a navegação funciona

A comunicação entre as telas usa **Intent explícita + extras**:

```kotlin
// Tela 1 — envia
val intent = Intent(this, DetalhesActivity::class.java).apply {
    putExtra(EXTRA_TITULO, titulo)
    putExtra(EXTRA_AUTOR, autor)
}
startActivity(intent)

// Tela 2 — recebe
val titulo = intent.getStringExtra(MainActivity.EXTRA_TITULO) ?: "(sem título)"
```

As chaves (`EXTRA_TITULO`, `EXTRA_AUTOR`) ficam em um `companion object` da
`MainActivity`, em vez de strings soltas nas duas telas. Assim, se você errar o
nome, o erro aparece na compilação e não em tempo de execução.

No `AndroidManifest.xml`, a segunda Activity precisa estar declarada:

```xml
<activity
    android:name=".DetalhesActivity"
    android:exported="false"
    android:label="@string/titulo_detalhes"
    android:parentActivityName=".MainActivity" />
```

- `exported="false"` — só o próprio app pode abrir essa tela.
- `parentActivityName` — faz a seta de voltar da barra superior funcionar.

## Fluxo de teste

1. Digite `Dom Casmurro` e `Machado de Assis` → **Cadastrar**.
2. A segunda tela abre mostrando os dois campos.
3. Volte pelo botão **Cadastrar outro livro**, pela seta da barra ou pelo botão
   voltar do sistema.
4. Teste também deixando um campo vazio: aparece o aviso de erro no próprio campo.

## Configuração

- Gradle 8.9 · AGP 8.7.3 · Kotlin 2.0.21
- `compileSdk` / `targetSdk` = 35 · `minSdk` = 24 · Java 17
- Views + XML, `AppCompatActivity` e `findViewById`

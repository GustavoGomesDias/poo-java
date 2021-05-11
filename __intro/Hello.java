// public => Deixa a class pública para todo o código

// static => diz que o membro pode ser acessado sem a necessidade da class se instanciada

// void => mesma coisa no C

// main => class principal, única necessário ára que o compilador identifique aonde irá iniciar o arquivo

public class Hello {
	public static void main(String args[]) {
		// System.out => um objeto para saída padrão (para arquivos, prints e etc);

		// println => Para falar que queremos printar (+/- igual a printf, console.log)

		System.out.println("Hello World");
	}
}

/* 
Para executar:
1. Ir para o diretório do arquivo e digitar
2. javac Hello.java
3. java Hello
*/
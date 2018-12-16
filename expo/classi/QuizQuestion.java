/**
 * Classe QuizQuestion. 
 * Questa classe riceve tramite costruttore il testo della domanda, le risposte sbagliate e la risposta corretta.
 * Mischia le risposte fra loro.
 *
 * @author Beffa Bryan
 * @author Forni Matteo
 * @version 27.02.2018
 */

public class QuizQuestion{
	/**
	 * Attributo che indica l'array contenente le risposte possibili alla domanda.
	 */
	private String[] answers;

	/**
	 * Attributo che indica l'indice dell'array contenente la risposta corretta.
	 */
	private int correctAnswer;

	/**
	 * Attributo che indica il testo della domanda.
	 */
	private String questionText;

	/**
	 * Metodo costruttore che riceve le possibili risposte, la risposta corretta, e il testo della domanda.
	 * Questo metodo mischiamo anche le possibili risposte.
	 * Una volta mischiate le risposte assegnamo all'attributo correctAnswer l'indice della risposta corretta.
	 * @param questionText parametro che indica il testo della domanda.
	 * @param correctAnswer parametro che rappresenta il testo della risposta corretta.
	 * @param wrongAnswers array che contiene il testo di tutte le possibili risposte.
	 */
	public QuizQuestion(String questionText, String correctAnswer, String[] wrongAnswers){
		//creo l'array di risposte composto da risposte sbagliate più una risposta corretta.
		answers = new String[wrongAnswers.length+1];
		//assegno all'attributo questionText la stringa contenente il testo
		this.questionText = questionText;
		//assegno i valori all'arrayAnswers
		for (int i=0; i<wrongAnswers.length; i++){
			answers[i] = wrongAnswers[i];
		}

		//mischiamo le risposte sbagliate tramite il metodo shuffleAnswers
		shuffleAnswers(answers, 100);

		//aggiungo la risposta giusta in una posizione casuale dell'array di risposte
		answers[answers.length-1] = correctAnswer;

		//scambio con una posizione casuale la risposta giusta
		int randomPosition = (int)(Math.random()*answers.length);
		String memory = answers[randomPosition];
		answers[randomPosition] = answers[answers.length-1];
		answers[answers.length-1] = memory;

		//assegno il valore all'attributo correctAnswer tramite il metodo getCorrectIndex
		this.correctAnswer = randomPosition;
	}

	/**
	 * Metodo getter dell'attributo questionText.
	 * Ritorna il testo della domanda.
	 * @return il testo della domanda.
	 */
	public String getQuestionText(){
		return questionText;
	}
	
	/**
	 * Metodo getter dell'attributo answers.
	 * Metodo che ritorna tutte le possibili risposte.
	 * @return le possibili risposte.
	 */
	public String[] getAnswers(){
		return answers;
	}

	/** 
	 * Metodo che ritorna il valore dell'attributo correctAnswer.
	 * @return il valore dell'attributo correctAnswer.
	 */
	public int getCorrectAnswer(){
		return correctAnswer;
	}

	/**
	 * Metodo che mischia i valori all'interno dell'array.
	 * @param answers le risposte da mischiare.
	 * @param times numero di volte che si mischia l'array.
	 * @return array di risposte mischiato.
	 */
	private String[] shuffleAnswers(String[] answers, int times){
		String memory;
		for(int i=0; i<times; i++){
			//creo un numero random da 1 al numero di risposte possbili
			int random = (int)(Math.random()*answers.length-2)+1;
			//memorizzo la risposta all'indice i e la scambio con una qualsiasi risposta (indice random)
			if(random != i%(answers.length-1)){
				memory = answers[i%(answers.length-1)];
				answers[i%(answers.length-1)] = answers[random];
				answers[random] = memory;
			}
		}
		return answers;
	}

	public static void main(String[] args) {
		String[] wrongAnswers = new String[10];
		for (int i=0; i<wrongAnswers.length; i++){
			wrongAnswers[i] = i + "";
		}

		QuizQuestion prova = new QuizQuestion("Quante dita ha una persona?", "20", wrongAnswers);
		System.out.println("\nDomanda: \n" + prova.getQuestionText());
		System.out.println("\nRisposte: ");
		for (int i=0; i<prova.getAnswers().length; i++){
			System.out.println((i+1) + ". " + prova.getAnswers()[i]);
		}
		System.out.println("\nRisposta corretta: \n" + (prova.getCorrectAnswer()+1) + ". " + prova.getAnswers()[prova.getCorrectAnswer()]);
	}
}
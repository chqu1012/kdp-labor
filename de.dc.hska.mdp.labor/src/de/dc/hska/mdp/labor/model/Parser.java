package de.dc.hska.mdp.labor.model;

public class Parser {

//	public Node parse(Node r1, String word){
//		char[] w = word.toCharArray();
//		for (char c : w) {
//			parse(r1, c);
//		}
//		return node;
//	}
	
	public Node parse(Node r1, char w ) {
		Node type = null;
		
		switch (r1.getType()) {
			case CHOICE: 
				type = checkChoice(r1, w);
				break;
			case EMPTY_LANGUAGE:
				type = new EmptyLanguage();
				break;
			case CONCAT:
				type = checkConcat(r1, w);
				break;
			case EMPTY_WORD:
				type = new EmptyWord();
				break;
			case LETTER:
				type = checkLetter(r1, w);
				break;
			case STAR:
				type = checkStar(r1, w);
				break;
			default:
				break;
		}
		
		return type;
	}

	private Node checkStar(Node r1, char w) {
		KleeneStar star = (KleeneStar)r1;
		return new Concat(parse(star.getR(), w), r1);
	}

	private Node checkConcat(Node node, char w) {
		Concat concat = (Concat)node;
		Node r1 = concat.getR1();
		Node r2 = concat.getR2();
		
		if(r1.isEmpty){
			Concat c1 = new Concat(parse(r1, w), r2);
			return new Choice(c1, parse(r2, w));
		}else{
			// Concat Optimierung
			if(r1.type==Type.EMPTY_WORD && r2.type!=Type.EMPTY_WORD)
				return new Letter(r2.letter);
			
			return new Concat(parse(r1, w), r2);
		}
	}

	private Node checkLetter(Node r, char w) {
		/** 
		 * Überprüfe wenn Knoten wirklich Buchstabe ist dann wird ein leeres Wort zurückgegeben
		 * ansonsten wird die eigentlich Buchstabe zurückgegeben
		 */
		
		if(r.getType()==Type.LETTER){
			Letter l = (Letter)r;			
			// wenn l1 == l2, dann epsilon,
			// ansonsten emptyLanguage
			if(l.contains(w))
				return new EmptyWord();
			else
				return new EmptyLanguage();
		}

		return r;
	}

	private Node checkChoice(Node node, char w) {
		Choice choice = (Choice)node;
		Node r1 = choice.getR1();
		Node r2 = choice.getR2();
		
		Node parse1 = parse(r1, w);
		Node parse2 = parse(r2, w);
		
		//TODO: 
		// Optimierung von Choice bei doppelte Alternativen
		if(parse1.letter==parse2.letter)
			return new Letter(parse1.letter);
		if(parse1.getType()==Type.EMPTY_LANGUAGE && parse2.getType()!=Type.EMPTY_LANGUAGE)
			return new Letter(parse2.letter);
		if(parse1.getType()!=Type.EMPTY_LANGUAGE && parse2.getType()==Type.EMPTY_LANGUAGE)
			return new Letter(parse1.letter);
		
		return new Choice(parse1, parse2);
	}
}

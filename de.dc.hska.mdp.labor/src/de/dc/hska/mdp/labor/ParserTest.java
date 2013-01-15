package de.dc.hska.mdp.labor;

import junit.framework.Assert;

import org.junit.Test;

import de.dc.hska.mdp.labor.model.Choice;
import de.dc.hska.mdp.labor.model.Concat;
import de.dc.hska.mdp.labor.model.EmptyLanguage;
import de.dc.hska.mdp.labor.model.EmptyWord;
import de.dc.hska.mdp.labor.model.KleeneStar;
import de.dc.hska.mdp.labor.model.Letter;
import de.dc.hska.mdp.labor.model.Node;
import de.dc.hska.mdp.labor.model.Parser;
import de.dc.hska.mdp.labor.model.Type;

public class ParserTest {
	
	/**
	 * emptyLanuage / l = emptyLanuage
	 */
	@Test
	public void testEmpptyLanguage(){
		EmptyLanguage el = new EmptyLanguage();
		Parser parser = new Parser();
		
		Node result = parser.parse(el, 'A');
		System.out.println("testEmpptyLanguage: "+result);
		Assert.assertEquals(result.getType(), Type.EMPTY_LANGUAGE);
	}

	/**
	 * emptyWord / l = emptyLanuage
	 */
	@Test
	public void testEmpptyWord(){
		EmptyWord ew = new EmptyWord();
		Parser parser = new Parser();
		
		Node result = parser.parse(ew, 'A');
		System.out.println("testEmpptyWord: "+result);
		Assert.assertEquals(result.getType(), Type.EMPTY_LANGUAGE);
	}

	/**
	 * l1 / l2 = epsilion wenn l1 == l2
	 */
	@Test
	public void testl1l2WithWord(){
		Letter l1 = new Letter('A');
		Parser parser = new Parser();
		
		Node result = parser.parse(l1, 'A');
		System.out.println("testl1l2WithWord: "+result);
		Assert.assertEquals(result.getType(), Type.EMPTY_WORD);
	}
	
	/**
	 * l1 / l2 = epsilion wenn l1 != l2
	 */
	@Test
	public void testl1l2WithoutWord(){
		Letter l1 = new Letter('A');
		Parser parser = new Parser();
		Node result = parser.parse(l1, 'B');
		System.out.println("testl1l2WithoutWord: "+result);
		Assert.assertEquals(result.getType(), Type.EMPTY_LANGUAGE);
	}
	
	/**
	 * (r1 + r2)\l
	 */
	@Test
	public void testChoice(){
		Letter r1 = new Letter('A');
		Letter r2 = new Letter('B');
		Choice choice = new Choice(r1, r2);
		Parser parser = new Parser();
		
		Node result = parser.parse(choice, 'B');
		System.out.println("testChoice: "+result);
	}

	@Test
	public void testChoiceOptimize(){
		Letter r1 = new Letter('A');
		Letter r2 = new Letter('B');
		Choice choice = new Choice(r1, r2);
		Parser parser = new Parser();
		
		Node result = parser.parse(choice, ' ');
		System.out.println("testChoice: "+result);
	}
	
	@Test
	public void testConcat1(){
		Letter r1 = new Letter('A');
		Letter r2 = new Letter('B');
		Concat concat = new Concat(r1, r2);
		Parser parser = new Parser();
		
		Node result = parser.parse(concat, 'B');
		System.out.println("testConcat1: "+result);
	}

	@Test
	public void testConcat2(){
		Letter r2 = new Letter('B');
		Concat concat = new Concat(new EmptyWord(), r2);
		Parser parser = new Parser();
		
		Node result = parser.parse(concat, 'B');
		System.out.println("testConcat2: "+result);
	}
	
	@Test
	public void testConcat3(){
		Letter r2 = new Letter('A');
		Concat concat = new Concat(new EmptyWord(), r2);
		Parser parser = new Parser();
		
		Node result = parser.parse(concat, 'B');
		System.out.println("testConcat3: "+result);
	}
	
	@Test
	public void testStar(){
		KleeneStar star = new KleeneStar(new Letter('A'));
		Parser parser = new Parser();
		
		Node result = parser.parse(star, 'A');
		System.out.println("testStar: "+result);
	}
	@Test
	public void test(){
		Concat con = new Concat(new Choice(new Letter('A'), new Letter('B')), new Letter('C'));
		Parser parser = new Parser();
		
		Node result = parser.parse(con, 'A');
		System.out.println("testStar: "+result);
	}
}
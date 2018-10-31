package suboard.board;

import static org.junit.Assert.*;

import org.junit.Test;

import suboard.board.Cell;

public class TestCell {

	@Test
	public void shouldCreateANewUnsolvedCell() {
		Cell c = new Cell();
		assertEquals(new Integer(0), c.getValue());
		assertArrayEquals(new boolean[] {true, true, true, true, true, true, true, true, true}, c.getCandidates());
		assertFalse(c.isSolved());
	}
	
	@Test
	public void shouldCreateASolvedCell() {
		Cell c = new Cell(1);
		assertArrayEquals(new boolean[] {true, false, false, false, false, false, false, false, false}, c.getCandidates());
		assertEquals(new Integer(1), c.getValue());
		assertTrue(c.isSolved());
	}

	@Test
	public void shouldCreateACellWithSomeCandidates() {
		Cell c = new Cell(new boolean[] {true, true, true, true, true, true, true, true, true});
		assertArrayEquals(new boolean[] {true, true, true, true, true, true, true, true, true}, c.getCandidates());
		assertEquals(new Integer(0), c.getValue());
		assertFalse(c.isSolved());
		Cell c2 = new Cell(new boolean[] {true, false, true, false, false, true, false, true, false});
		assertArrayEquals(new boolean[] {true, false, true, false, false, true, false, true, false}, c2.getCandidates());
		assertEquals(new Integer(0), c2.getValue());
		assertFalse(c2.isSolved());
	}
	
}

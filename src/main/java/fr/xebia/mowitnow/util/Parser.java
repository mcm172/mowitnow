package fr.xebia.mowitnow.util;

public interface Parser<I, O> {
	O parse(I input);
}

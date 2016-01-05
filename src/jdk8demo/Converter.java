package jdk8demo;

@FunctionalInterface
public interface Converter<F, T> {

	T convent(F from);

}

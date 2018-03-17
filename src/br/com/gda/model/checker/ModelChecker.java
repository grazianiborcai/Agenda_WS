package br.com.gda.model.checker;

import java.util.List;

public interface ModelChecker<T> {
	public boolean check(List<T> recordInfos);
	public boolean check(T recordInfo);
	public boolean getExpectedResult();
	public String getFailureExplanation();
	public int getFailureCode();
}

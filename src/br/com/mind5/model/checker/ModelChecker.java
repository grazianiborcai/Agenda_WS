package br.com.mind5.model.checker;

import java.util.List;

public interface ModelChecker<T> {
	public boolean check(List<T> recordInfos);
	public boolean check(T recordInfo);
	public boolean getResult();
	public String getFailMessage();
	public int getFailCode();
}

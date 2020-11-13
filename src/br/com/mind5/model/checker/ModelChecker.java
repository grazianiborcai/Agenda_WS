package br.com.mind5.model.checker;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface ModelChecker<T extends InfoRecord> {
	public boolean check(List<T> recordInfos);
	public boolean check(T recordInfo);
	public boolean getResult();
	public String getFailMessage();
	public int getFailCode();
	public void close();
}

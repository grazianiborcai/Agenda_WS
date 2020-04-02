package br.com.mind5.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;

final class DeciTreeHelperOption<T extends InfoRecord> {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	public ModelChecker<T> visitorChecker;
	public List<ActionStdV1<T>> actionsOnPassed;
	public List<ActionStdV1<T>> actionsOnFailed;	
}

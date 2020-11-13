package br.com.mind5.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;

final class DeciTreeHelperOption<T extends InfoRecord> {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	public ModelCheckerV1<T> visitorChecker;
	public List<ActionStdV2<T>> actionsOnPassed;
	public List<ActionStdV2<T>> actionsOnFailed;	
}

package br.com.mind5.masterData.materialUnit.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.action.MatunitVisiDaoSelect;
import br.com.mind5.masterData.materialUnit.model.checker.MatunitCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatunitRootSelect extends DeciTreeTemplateRead<MatunitInfo> {
	
	public MatunitRootSelect(DeciTreeOption<MatunitInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatunitInfo> buildCheckerHook(DeciTreeOption<MatunitInfo> option) {
		List<ModelChecker<MatunitInfo>> queue = new ArrayList<>();		
		ModelChecker<MatunitInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatunitCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatunitInfo>> buildActionsOnPassedHook(DeciTreeOption<MatunitInfo> option) {
		List<ActionStd<MatunitInfo>> actions = new ArrayList<>();
		
		ActionStd<MatunitInfo> select = new ActionStdCommom<MatunitInfo>(option, MatunitVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}

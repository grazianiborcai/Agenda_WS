package br.com.mind5.masterData.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicy.model.action.RefupoVisiDaoSelect;
import br.com.mind5.masterData.refundPolicy.model.checker.RefupoCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RefupoRootSelect extends DeciTreeTemplateRead<RefupoInfo> {
	
	public RefupoRootSelect(DeciTreeOption<RefupoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefupoInfo> buildCheckerHook(DeciTreeOption<RefupoInfo> option) {
		List<ModelChecker<RefupoInfo>> queue = new ArrayList<>();		
		ModelChecker<RefupoInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupoCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefupoInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupoInfo> option) {
		List<ActionStd<RefupoInfo>> actions = new ArrayList<>();
		
		ActionStd<RefupoInfo> select = new ActionStdCommom<RefupoInfo>(option, RefupoVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}

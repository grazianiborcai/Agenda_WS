package br.com.mind5.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.action.StdCusnapMergeUselis;
import br.com.mind5.business.customerSnapshot.model.action.StdCusnapSuccess;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckHasUser;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeCusnapUser extends DeciTreeTemplateRead<CusnapInfo> {
	
	public NodeCusnapUser(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusnapInfo> buildCheckerHook(DeciTreeOption<CusnapInfo> option) {
		List<ModelChecker<CusnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CusnapInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusnapCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStd<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CusnapInfo> mergeUselis = new StdCusnapMergeUselis(option);
		
		actions.add(mergeUselis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusnapInfo>> buildActionsOnFailedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStd<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CusnapInfo> success = new StdCusnapSuccess(option);
		
		actions.add(success);
		return actions;
	}
}

package br.com.mind5.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.action.CusnapVisiMergeUselis;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckHasUser;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CusnapNodeUser extends DeciTreeTemplateRead<CusnapInfo> {
	
	public CusnapNodeUser(DeciTreeOption<CusnapInfo> option) {
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
		
		ActionStd<CusnapInfo> mergeUselis = new ActionStdCommom<CusnapInfo>(option, CusnapVisiMergeUselis.class);
		
		actions.add(mergeUselis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusnapInfo>> buildActionsOnFailedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStd<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CusnapInfo> success = new ActionStdSuccessCommom<CusnapInfo>(option);
		
		actions.add(success);
		return actions;
	}
}

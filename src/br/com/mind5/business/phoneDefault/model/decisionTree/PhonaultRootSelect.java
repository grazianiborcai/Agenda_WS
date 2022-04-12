package br.com.mind5.business.phoneDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.action.PhonaultVisiMergeToSelect;
import br.com.mind5.business.phoneDefault.model.checker.PhonaultCheckLangu;
import br.com.mind5.business.phoneDefault.model.checker.PhonaultCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhonaultRootSelect extends DeciTreeTemplateWrite<PhonaultInfo> {
	
	public PhonaultRootSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhonaultInfo> buildCheckerHook(DeciTreeOption<PhonaultInfo> option) {
		List<ModelChecker<PhonaultInfo>> queue = new ArrayList<>();		
		ModelChecker<PhonaultInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhonaultCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhonaultCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhonaultInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonaultInfo> option) {
		List<ActionStd<PhonaultInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhonaultInfo> select = new ActionStdCommom<PhonaultInfo>(option, PhonaultVisiMergeToSelect.class);
		
		actions.add(select);			
		return actions;
	}
}

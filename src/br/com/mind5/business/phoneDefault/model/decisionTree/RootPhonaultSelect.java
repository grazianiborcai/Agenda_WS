package br.com.mind5.business.phoneDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.action.StdPhonaultMergeToSelect;
import br.com.mind5.business.phoneDefault.model.checker.PhonaultCheckLangu;
import br.com.mind5.business.phoneDefault.model.checker.PhonaultCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootPhonaultSelect extends DeciTreeTemplateWriteV2<PhonaultInfo> {
	
	public RootPhonaultSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PhonaultInfo> buildCheckerHook(DeciTreeOption<PhonaultInfo> option) {
		List<ModelCheckerV1<PhonaultInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PhonaultInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PhonaultInfo>> buildActionsOnPassedHook(DeciTreeOption<PhonaultInfo> option) {
		List<ActionStdV1<PhonaultInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PhonaultInfo> select = new StdPhonaultMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}

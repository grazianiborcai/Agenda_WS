package br.com.mind5.business.addressDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.action.StdAddaultMergeToSelect;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckLangu;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootAddaultSelect extends DeciTreeTemplateWriteV2<AddaultInfo> {
	
	public RootAddaultSelect(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AddaultInfo> buildCheckerHook(DeciTreeOption<AddaultInfo> option) {
		List<ModelCheckerV1<AddaultInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AddaultInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddaultCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddaultCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<AddaultInfo>> buildActionsOnPassedHook(DeciTreeOption<AddaultInfo> option) {
		List<ActionStdV2<AddaultInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<AddaultInfo> select = new StdAddaultMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}

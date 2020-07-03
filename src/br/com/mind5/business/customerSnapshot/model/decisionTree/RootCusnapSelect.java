package br.com.mind5.business.customerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.business.customerSnapshot.model.action.StdCusnapMergeToSelect;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckLangu;
import br.com.mind5.business.customerSnapshot.model.checker.CusnapCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCusnapSelect extends DeciTreeTemplateReadV2<CusnapInfo> {
	
	public RootCusnapSelect(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusnapInfo> buildCheckerHook(DeciTreeOption<CusnapInfo> option) {
		List<ModelCheckerV1<CusnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusnapInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusnapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusnapCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CusnapInfo> option) {
		List<ActionStdV1<CusnapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusnapInfo> select = new StdCusnapMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}

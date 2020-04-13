package br.com.mind5.business.orderSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.model.action.StdOrdnapMergeToSelect;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckLangu;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckOwner;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootOrdnapSelect extends DeciTreeTemplateReadV1<OrdnapInfo> {
	
	public RootOrdnapSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdnapInfo> buildCheckerHook(DeciTreeOption<OrdnapInfo> option) {
		List<ModelCheckerV1<OrdnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdnapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdnapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdnapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdnapInfo> option) {
		List<ActionStdV1<OrdnapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<OrdnapInfo> select = new StdOrdnapMergeToSelect(option);
		
		actions.add(select);			
		return actions;
	}
}

package br.com.mind5.business.storeLeaveDateRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.action.StdStolargMergeToSelect;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckLangu;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckOwner;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckRead;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckStore;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public class RootStolargSelect extends DeciTreeTemplateReadV2<StolargInfo> {
	
	public RootStolargSelect(DeciTreeOption<StolargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StolargInfo> buildCheckerHook(DeciTreeOption<StolargInfo> option) {
		List<ModelCheckerV1<StolargInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StolargInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolargCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StolargInfo>> buildActionsOnPassedHook(DeciTreeOption<StolargInfo> option) {
		List<ActionStdV2<StolargInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StolargInfo> select = new StdStolargMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}

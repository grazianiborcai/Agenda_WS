package br.com.mind5.payment.storePartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.action.StdStoparchMergeToSelect;
import br.com.mind5.payment.storePartnerSearch.model.checker.StoparchCheckOwner;
import br.com.mind5.payment.storePartnerSearch.model.checker.StoparchCheckRead;

public final class RootStoparchSelect extends DeciTreeTemplateReadV2<StoparchInfo> {
	
	public RootStoparchSelect(DeciTreeOption<StoparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoparchInfo> buildCheckerHook(DeciTreeOption<StoparchInfo> option) {
		List<ModelCheckerV1<StoparchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoparchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoparchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoparchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoparchInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparchInfo> option) {
		List<ActionStdV1<StoparchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoparchInfo> select = new StdStoparchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}

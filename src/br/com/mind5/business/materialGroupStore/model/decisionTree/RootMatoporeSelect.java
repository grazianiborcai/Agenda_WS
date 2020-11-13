package br.com.mind5.business.materialGroupStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.business.materialGroupStore.model.action.StdMatoporeMergeMatore;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckLangu;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckOwner;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckRead;
import br.com.mind5.business.materialGroupStore.model.checker.MatoporeCheckStore;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatoporeSelect extends DeciTreeTemplateReadV2<MatoporeInfo> {
	
	public RootMatoporeSelect(DeciTreeOption<MatoporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoporeInfo> buildCheckerHook(DeciTreeOption<MatoporeInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelCheckerV1<MatoporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoporeInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoporeCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoporeCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoporeCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoporeCheckStore(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatoporeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoporeInfo> option) {
		List<ActionStdV2<MatoporeInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatoporeInfo> mergeMatore = new StdMatoporeMergeMatore(option);
		
		actions.add(mergeMatore);		
		return actions;
	}
}

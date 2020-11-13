package br.com.mind5.business.materialStoreSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.materialStoreSnapshot.model.action.StdMatorapMergeToSelect;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckLangu;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckMatore;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckOwner;
import br.com.mind5.business.materialStoreSnapshot.model.checker.MatorapCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatorapSelect extends DeciTreeTemplateReadV2<MatorapInfo> {
	
	public RootMatorapSelect(DeciTreeOption<MatorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatorapInfo> buildCheckerHook(DeciTreeOption<MatorapInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelCheckerV1<MatorapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatorapInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatorapCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorapCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatorapCheckMatore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatorapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatorapInfo> option) {
		List<ActionStdV2<MatorapInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatorapInfo> select = new StdMatorapMergeToSelect(option);
		
		actions.add(select);		
		return actions;
	}
}

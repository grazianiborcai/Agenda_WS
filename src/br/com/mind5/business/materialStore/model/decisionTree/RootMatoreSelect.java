package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceRange;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeMatlis;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeStolis;
import br.com.mind5.business.materialStore.model.action.StdMatoreMergeToSelect;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckLangu;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckMat;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckOwner;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckRead;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatoreSelect extends DeciTreeTemplateReadV2<MatoreInfo> {
	
	public RootMatoreSelect(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelCheckerV1<MatoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoreInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoreCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckMat(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatoreInfo> select = new StdMatoreMergeToSelect(option);
		ActionLazy<MatoreInfo> enforceRange = new LazyMatoreEnforceRange(option.conn, option.schemaName);	
		ActionLazy<MatoreInfo> mergeMatlis = new LazyMatoreMergeMatlis(option.conn, option.schemaName);		
		ActionLazy<MatoreInfo> mergeStolis = new LazyMatoreMergeStolis(option.conn, option.schemaName);	
		
		select.addPostAction(enforceRange);
		enforceRange.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeStolis);
		
		actions.add(select);		
		return actions;
	}
}

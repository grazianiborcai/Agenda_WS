package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemDaoUpdate;
import br.com.mind5.business.cartItem.model.action.StdCartemMergeToUpdate;
import br.com.mind5.business.cartItem.model.checker.CartemCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartemUpsertL2 extends DeciTreeTemplateWriteV2<CartemInfo> {
	
	public NodeCartemUpsertL2(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelCheckerV1<CartemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartemCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV2<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CartemInfo> mergeToUpdate = new StdCartemMergeToUpdate(option);	
		ActionLazy<CartemInfo> update = new LazyCartemDaoUpdate(option.conn, option.schemaName);			
		
		mergeToUpdate.addPostAction(update);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<CartemInfo>> buildActionsOnFailedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV2<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CartemInfo> insert = new NodeCartemInsert(option).toAction();	
		
		actions.add(insert);		
		return actions;
	}
}

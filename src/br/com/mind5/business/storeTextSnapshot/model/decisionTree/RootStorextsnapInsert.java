package br.com.mind5.business.storeTextSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.business.storeTextSnapshot.model.action.LazyStorextsnapDaoInsert;
import br.com.mind5.business.storeTextSnapshot.model.action.StdStorextsnapMergeStorext;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckStorext;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckOwner;
import br.com.mind5.business.storeTextSnapshot.model.checker.StorextsnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStorextsnapInsert extends DeciTreeTemplateWriteV2<StorextsnapInfo> {
	
	public RootStorextsnapInsert(DeciTreeOption<StorextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextsnapInfo> buildCheckerHook(DeciTreeOption<StorextsnapInfo> option) {		
		List<ModelCheckerV1<StorextsnapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextsnapCheckStorext(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextsnapInfo> option) {
		List<ActionStdV1<StorextsnapInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorextsnapInfo> mergeStorext = new StdStorextsnapMergeStorext(option);	
		ActionLazy<StorextsnapInfo> insert = new LazyStorextsnapDaoInsert(option.conn, option.schemaName);	
		
		mergeStorext.addPostAction(insert);
		
		actions.add(mergeStorext);
		return actions;
	}
}

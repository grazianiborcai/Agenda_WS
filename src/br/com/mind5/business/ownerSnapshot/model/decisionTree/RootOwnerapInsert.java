package br.com.mind5.business.ownerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.model.action.LazyOwnerapInsert;
import br.com.mind5.business.ownerSnapshot.model.action.LazyOwnerapMergeComplis;
import br.com.mind5.business.ownerSnapshot.model.action.LazyOwnerapMergeUselis;
import br.com.mind5.business.ownerSnapshot.model.action.StdOwnerapMergePersolis;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckLangu;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckOwner;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootOwnerapInsert extends DeciTreeTemplateWriteV1<OwnerapInfo> {
	
	public RootOwnerapInsert(DeciTreeOption<OwnerapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnerapInfo> buildCheckerHook(DeciTreeOption<OwnerapInfo> option) {
		List<ModelCheckerV1<OwnerapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnerapInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnerapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerapInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerapInfo> option) {
		List<ActionStdV1<OwnerapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnerapInfo> mergePersolis = new StdOwnerapMergePersolis(option);
		ActionLazyV1<OwnerapInfo> mergeUselis = new LazyOwnerapMergeUselis(option.conn, option.schemaName);
		ActionLazyV1<OwnerapInfo> mergeComplis = new LazyOwnerapMergeComplis(option.conn, option.schemaName);
		ActionLazyV1<OwnerapInfo> insert = new LazyOwnerapInsert(option.conn, option.schemaName);
		
		mergePersolis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(mergeComplis);
		mergeComplis.addPostAction(insert);
		
		actions.add(mergePersolis);	
		return actions;
	}
}

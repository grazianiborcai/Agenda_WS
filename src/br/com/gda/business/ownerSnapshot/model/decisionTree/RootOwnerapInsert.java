package br.com.gda.business.ownerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.ownerSnapshot.model.action.LazyOwnerapInsert;
import br.com.gda.business.ownerSnapshot.model.action.LazyOwnerapMergeComplis;
import br.com.gda.business.ownerSnapshot.model.action.LazyOwnerapMergeUselis;
import br.com.gda.business.ownerSnapshot.model.action.StdOwnerapMergePersolis;
import br.com.gda.business.ownerSnapshot.model.checker.OwnerapCheckLangu;
import br.com.gda.business.ownerSnapshot.model.checker.OwnerapCheckOwner;
import br.com.gda.business.ownerSnapshot.model.checker.OwnerapCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOwnerapInsert extends DeciTreeWriteTemplate<OwnerapInfo> {
	
	public RootOwnerapInsert(DeciTreeOption<OwnerapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerapInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerapInfo> option) {
		List<ModelChecker<OwnerapInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerapInfo> checker;
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerapInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerapInfo> option) {
		List<ActionStd<OwnerapInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerapInfo> mergePersolis = new StdOwnerapMergePersolis(option);
		ActionLazy<OwnerapInfo> mergeUselis = new LazyOwnerapMergeUselis(option.conn, option.schemaName);
		ActionLazy<OwnerapInfo> mergeComplis = new LazyOwnerapMergeComplis(option.conn, option.schemaName);
		ActionLazy<OwnerapInfo> insert = new LazyOwnerapInsert(option.conn, option.schemaName);
		
		mergePersolis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(mergeComplis);
		mergeComplis.addPostAction(insert);
		
		actions.add(mergePersolis);	
		return actions;
	}
}

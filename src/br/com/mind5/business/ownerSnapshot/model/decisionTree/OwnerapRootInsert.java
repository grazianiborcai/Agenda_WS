package br.com.mind5.business.ownerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.model.action.OwnerapVisiDaoInsert;
import br.com.mind5.business.ownerSnapshot.model.action.OwnerapVisiMergeComplis;
import br.com.mind5.business.ownerSnapshot.model.action.OwnerapVisiMergePersolis;
import br.com.mind5.business.ownerSnapshot.model.action.OwnerapVisiMergeUselis;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckLangu;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckOwner;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OwnerapRootInsert extends DeciTreeTemplateWrite<OwnerapInfo> {
	
	public OwnerapRootInsert(DeciTreeOption<OwnerapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerapInfo> buildCheckerHook(DeciTreeOption<OwnerapInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerapInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerapInfo> option) {
		List<ActionStd<OwnerapInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerapInfo> mergePersolis = new ActionStdCommom<OwnerapInfo>(option, OwnerapVisiMergePersolis.class);
		ActionLazy<OwnerapInfo> mergeUselis = new ActionLazyCommom<OwnerapInfo>(option, OwnerapVisiMergeUselis.class);
		ActionLazy<OwnerapInfo> mergeComplis = new ActionLazyCommom<OwnerapInfo>(option, OwnerapVisiMergeComplis.class);
		ActionLazy<OwnerapInfo> insert = new ActionLazyCommom<OwnerapInfo>(option, OwnerapVisiDaoInsert.class);
		
		mergePersolis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(mergeComplis);
		mergeComplis.addPostAction(insert);
		
		actions.add(mergePersolis);	
		return actions;
	}
}

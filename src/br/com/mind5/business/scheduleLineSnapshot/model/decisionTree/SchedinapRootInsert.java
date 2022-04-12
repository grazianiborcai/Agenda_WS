package br.com.mind5.business.scheduleLineSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiNodePet;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiDaoInsert;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiMergeCuslis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiMergeEmplres;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiMergeMatlis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiMergeStolis;
import br.com.mind5.business.scheduleLineSnapshot.model.action.SchedinapVisiMergeUselis;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckLangu;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckOwner;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckSchedine;
import br.com.mind5.business.scheduleLineSnapshot.model.checker.SchedinapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedinapRootInsert extends DeciTreeTemplateWrite<SchedinapInfo> {
	
	public SchedinapRootInsert(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedinapInfo> buildCheckerHook(DeciTreeOption<SchedinapInfo> option) {
		List<ModelChecker<SchedinapInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedinapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedinapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedinapCheckSchedine(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedinapInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedinapInfo> option) {
		List<ActionStd<SchedinapInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedinapInfo> mergeMatlis = new ActionStdCommom<SchedinapInfo>(option, SchedinapVisiMergeMatlis.class);
		ActionLazy<SchedinapInfo> mergeStolis = new ActionLazyCommom<SchedinapInfo>(option, SchedinapVisiMergeStolis.class);
		ActionLazy<SchedinapInfo> mergCuslis = new ActionLazyCommom<SchedinapInfo>(option, SchedinapVisiMergeCuslis.class);
		ActionLazy<SchedinapInfo> mergUselis = new ActionLazyCommom<SchedinapInfo>(option, SchedinapVisiMergeUselis.class);
		ActionLazy<SchedinapInfo> mergeEmplres = new ActionLazyCommom<SchedinapInfo>(option, SchedinapVisiMergeEmplres.class);
		ActionLazy<SchedinapInfo> nodePet = new ActionLazyCommom<SchedinapInfo>(option, SchedinapVisiNodePet.class);
		ActionLazy<SchedinapInfo> insert = new ActionLazyCommom<SchedinapInfo>(option, SchedinapVisiDaoInsert.class);
		
		mergeMatlis.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergCuslis);		
		mergCuslis.addPostAction(mergUselis);		
		mergUselis.addPostAction(mergeEmplres);
		mergeEmplres.addPostAction(nodePet);
		nodePet.addPostAction(insert);
		
		actions.add(mergeMatlis);
		return actions;
	}
}

package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.MatoreVisiNodeDelete;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceLChanged;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeMatock;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeToDelete;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeUsername;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckStorauth;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoreRootDelete extends DeciTreeTemplateWrite<MatoreInfo> {
	
	public MatoreRootDelete(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {		
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoreCheckWrite(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckStorauth(checkerOption);
		queue.add(checker);		
		
		//TODO: Verificar conflito com MatEmp ou eliminar MatEmp impactados
		return new ModelCheckerHelperQueue<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatoreInfo> mergeToDelete = new ActionStdCommom<MatoreInfo>(option, MatoreVisiMergeToDelete.class);
		ActionLazy<MatoreInfo> enforceLChanged = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceLChanged.class);
		ActionLazy<MatoreInfo> enforceLChangedBy = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeUsername.class);
		ActionLazy<MatoreInfo> mergeMatock = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeMatock.class);
		ActionLazy<MatoreInfo> nodeDelete = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiNodeDelete.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(mergeMatock);
		mergeMatock.addPostAction(nodeDelete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}

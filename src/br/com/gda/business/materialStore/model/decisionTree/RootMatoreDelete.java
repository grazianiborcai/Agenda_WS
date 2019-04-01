package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.action.LazyMatoreEnforceLChanged;
import br.com.gda.business.materialStore.model.action.LazyMatoreMergeMatock;
import br.com.gda.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.gda.business.materialStore.model.action.LazyMatoreNodeDelete;
import br.com.gda.business.materialStore.model.action.StdMatoreMergeToDelete;
import br.com.gda.business.materialStore.model.checker.MatoreCheckExist;
import br.com.gda.business.materialStore.model.checker.MatoreCheckStorauth;
import br.com.gda.business.materialStore.model.checker.MatoreCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatoreDelete extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public RootMatoreDelete(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		
		checker = new MatoreCheckWrite();
		queue.add(checker);			
		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatoreCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatoreCheckStorauth(checkerOption);
		queue.add(checker);		
		
		//TODO: Verificar conflito com MatEmp ou eliminar MatEmp impactados
		return new ModelCheckerQueue<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatoreInfo> mergeToDelete = new StdMatoreMergeToDelete(option);
		ActionLazy<MatoreInfo> enforceLChanged = new LazyMatoreEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> mergeMatock = new LazyMatoreMergeMatock(option.conn, option.schemaName);
		ActionLazy<MatoreInfo> nodeDelete = new LazyMatoreNodeDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(mergeMatock);
		mergeMatock.addPostAction(nodeDelete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}

package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreEnforceLChanged;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeMatock;
import br.com.mind5.business.materialStore.model.action.LazyMatoreMergeUsername;
import br.com.mind5.business.materialStore.model.action.LazyMatoreNodeDelete;
import br.com.mind5.business.materialStore.model.action.StdMatoreMergeToDelete;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckStorauth;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatoreDelete extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public RootMatoreDelete(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {		
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
		return new ModelCheckerQueue<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatoreInfo> mergeToDelete = new StdMatoreMergeToDelete(option);
		ActionLazyV1<MatoreInfo> enforceLChanged = new LazyMatoreEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> enforceLChangedBy = new LazyMatoreMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> mergeMatock = new LazyMatoreMergeMatock(option.conn, option.schemaName);
		ActionLazyV1<MatoreInfo> nodeDelete = new LazyMatoreNodeDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(mergeMatock);
		mergeMatock.addPostAction(nodeDelete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}

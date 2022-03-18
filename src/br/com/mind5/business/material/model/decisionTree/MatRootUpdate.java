package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.MatVisiMergeToUpdate;
import br.com.mind5.business.material.model.action.MatVisiNodeServiceL1;
import br.com.mind5.business.material.model.action.MatVisiNodeSytotauh;
import br.com.mind5.business.material.model.action.MatVisiNodeUpdate;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.material.model.checker.MatCheckLangu;
import br.com.mind5.business.material.model.checker.MatCheckMateg;
import br.com.mind5.business.material.model.checker.MatCheckMatoup;
import br.com.mind5.business.material.model.checker.MatCheckMatubup;
import br.com.mind5.business.material.model.checker.MatCheckMatunit;
import br.com.mind5.business.material.model.checker.MatCheckMatype;
import br.com.mind5.business.material.model.checker.MatCheckOwner;
import br.com.mind5.business.material.model.checker.MatCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatRootUpdate extends DeciTreeTemplateWrite<MatInfo> {
	
	public MatRootUpdate(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatunit(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMateg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatoup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatubup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatype(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();

		ActionStd<MatInfo> mergeToUpdate = new ActionStdCommom<MatInfo>(option, MatVisiMergeToUpdate.class);		
		ActionLazy<MatInfo> nodeSytotauh = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeSytotauh.class);
		ActionLazy<MatInfo> nodeService = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeServiceL1.class);		
		ActionLazy<MatInfo> nodeL1 = new ActionLazyCommom<MatInfo>(option.conn, option.schemaName, MatVisiNodeUpdate.class);	
		
		mergeToUpdate.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(nodeService);
		nodeService.addPostAction(nodeL1);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}

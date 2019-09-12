package br.com.gda.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.LazyFimgEnforceFullname;
import br.com.gda.file.fileImage.model.action.LazyFimgWriteOnDisk;
import br.com.gda.file.fileImage.model.action.StdFimgMergeFath;
import br.com.gda.file.fileImage.model.checker.FimgCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeFimgWrite extends DeciTreeWriteTemplate<FimgInfo> {
	
	public NodeFimgWrite(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		
		checker = new FimgCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeFath = new StdFimgMergeFath(option);	
		ActionLazy<FimgInfo> enforceFullname = new LazyFimgEnforceFullname(option.conn, option.schemaName);
		ActionLazy<FimgInfo> writeOnDisk = new LazyFimgWriteOnDisk(option.conn, option.schemaName);
		
		mergeFath.addPostAction(enforceFullname);
		enforceFullname.addPostAction(writeOnDisk);
		
		actions.add(mergeFath);		
		return actions;
	}
}

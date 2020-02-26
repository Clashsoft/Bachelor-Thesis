abstract org.fulib.scenarios.ast.Node {
	// ...
	ScenarioGroup(sourceDir: String, packageDir: String,
	              files: [String:ScenarioFile]
	              classes: [String:ClassDecl])

	Positioned {
		// ...
		abstract decl.Decl(readonly name: String, readonly type: Type) {
			// ...
			ClassDecl(group: ScenarioGroup, name: String, type: Type,
			          attributes: [String:AttributeDecl], ...)
            AttributeDecl(owner: ClassDecl, name: String, type: Type)
		}

		abstract type.Type {
			// ...
			ClassType(classDecl: ClassDecl)
		}
	}
}

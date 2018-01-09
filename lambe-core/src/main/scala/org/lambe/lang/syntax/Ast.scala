package org.lambe.lang.syntax

object TypeDef {
  type Generics = List[(String, TypeAst)]
  type Parameters = List[TypeAst]
}

trait TypeAst

case class TypeIdentifier(name: String) extends TypeAst

case class TypeApplication(left: TypeAst, right: TypeAst) extends TypeAst

case class TypeAbstraction(left: TypeAst, right: TypeAst) extends TypeAst

trait EntityAst

case class DataEntity(name: String, generics: TypeDef.Generics, parameters: TypeDef.Parameters, spec: TypeAst) extends EntityAst
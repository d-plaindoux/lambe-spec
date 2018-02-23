/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */

package org.lambe.lang.compiler

import org.lambe.lang.syntax._
import org.scalatest._

import scala.util.Success

class GammaSpec extends FlatSpec with Matchers with Coercions {

  "id" should "be a function in Gamma" in {
    Gamma(List(DefinitionEntity(ValueType("id", List(), TypeAbstraction("a", "a"))))).
      findFunction("id") shouldBe
      Some((List(), TypeAbstraction("a", "a")))
  }

  "id" should "not be a data in Gamma" in {
    Gamma(List(DefinitionEntity(ValueType("id", List(), TypeAbstraction("a", "a"))))).
      findData("id") shouldBe
      None
  }

  "id" should "be a data in Gamma" in {
    Gamma(List(DataEntity("id", List(), TypeAbstraction("a", "a")))).
      findData("id") shouldBe
      Some((List(), TypeAbstraction("a", "a")))
  }

  "id" should "not be a function in Gamma" in {
    Gamma(List(DataEntity("id", List(), TypeAbstraction("a", "a")))).
      findFunction("id") shouldBe
      None
  }

  "id" should "be a defined in Gamma" in {
    Gamma(List(DataEntity("id", List(), TypeAbstraction("a", "a")))).
      findType("id") shouldBe
      Some((List(), TypeAbstraction("a", "a")))
  }

}
/*
 * Copyright 2002-2003 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 *  
 */

/* 
 * Original code for this class taken from the Java HotSpot VM. 
 * Modified for use with the Jakstab project. All modifications 
 * Copyright 2007-2015 Johannes Kinder <jk@jakstab.org>
 */

package org.jakstab.disasm.x86;

import org.jakstab.asm.Instruction;
import org.jakstab.asm.Operand;
import org.jakstab.asm.x86.X86InstructionFactory;
import org.jakstab.util.BinaryInputBuffer;

class FPLoadDecoder extends FPInstructionDecoder {
   FPLoadDecoder(String name, int addrMode1, int operandType1) {
      super(name, addrMode1, operandType1);
   }

   protected Instruction decodeInstruction(BinaryInputBuffer bytesArray, boolean operandSize, boolean addrSize, X86InstructionFactory factory) {
      Operand op = getOperand1(bytesArray, operandSize, addrSize);
      int size = byteIndex - instrStartIndex;
      return factory.newFPLoadInstruction(name, op, size, prefixes);
   }
}

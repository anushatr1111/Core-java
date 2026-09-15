"""
Master Content Registry for Core Java Complete Notes
Combines all modules, topics, and complete repository file references.
"""

from .data_mod1_mod5 import MODULE_1_5_METADATA, PROBLEMS_MOD1_MOD5
from .data_mod6_mod10 import MODULE_6_10_METADATA, PROBLEMS_MOD6_MOD10
from .data_mod11_mod17 import MODULE_11_17_METADATA, PROBLEMS_MOD11_MOD17

ALL_MODULES = MODULE_1_5_METADATA + MODULE_6_10_METADATA + MODULE_11_17_METADATA
ALL_PROBLEMS = PROBLEMS_MOD1_MOD5 + PROBLEMS_MOD6_MOD10 + PROBLEMS_MOD11_MOD17

def get_module_by_id(mod_id):
    for m in ALL_MODULES:
        if m["id"] == mod_id:
            return m
    return None

def get_problems_by_module(mod_id):
    return [p for p in ALL_PROBLEMS if p["module_id"] == mod_id]

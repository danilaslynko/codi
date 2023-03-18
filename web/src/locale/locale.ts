/// <reference path="./locale.d.ts" />

let localeSuffix = navigator.language.startsWith('ru') ? 'ru' : 'en';
export const locale = require('./locale_' + localeSuffix).locale as Locale

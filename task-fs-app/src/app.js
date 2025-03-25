import {LitElement, html} from 'lit';

export class AppElement extends LitElement {

    constructor() {
        super();
    }

    render() {
        return html`
            <p>App Component</p>
        `;
    }
}

customElements.define('app-element', AppElement);
